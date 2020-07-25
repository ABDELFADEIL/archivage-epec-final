import {Component, OnInit, ViewChild} from '@angular/core';
import {ClientService} from '../../service/client.service';
import {Router} from '@angular/router';
import {Document} from '../../models/document';
import {ClassificationNatureService} from '../../service/classification-nature.service';
import {ClassificationNature} from '../../models/classification-nature';
import { NgbModal, NgbTypeahead} from '@ng-bootstrap/ng-bootstrap';
import {Observable, Subject, merge} from 'rxjs';
import {debounceTime, distinctUntilChanged, filter, map} from 'rxjs/operators';
import {Client} from '../../models/client';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {departs} from '../../../environments/departs';
import {NewContractComponent} from '../../new-contract/new-contract.component';







@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.css']
})
export class NewClientComponent implements OnInit {
  public files: File [] = [];
  public document: Document;
  public model;
  public modelDep;
  client: Client;


  @ViewChild('instance', {static: true}) instance: NgbTypeahead;

  public classificationNatures: ClassificationNature [] = [];
  public created: boolean;
  public clientId: number;


  constructor(private clientService: ClientService, private router: Router) {
  }

  ngOnInit(): void {
    this.initializeFormGroup();
  }


    form :FormGroup = new FormGroup({
      // client_id: new FormControl(null),
      client_name: new FormControl('', [Validators.required, Validators.minLength(4)]),
      client_first_name: new FormControl('', [Validators.required, Validators.minLength(4)]),
      client_nature_id: new FormControl('', [Validators.required, Validators.minLength(1)]),
      civility_id: new FormControl('', [Validators.required, Validators.minLength(1)]),
      birth_date: new FormControl('', Validators.required),
      birth_dept: new FormControl('', Validators.required),
      siren_number: new FormControl(''),
      siret_number: new FormControl(''),
      files: new FormControl('', Validators.required),
    });

  initializeFormGroup() {
    this.form.setValue({
      client_name: '',
      client_first_name: '',
      client_nature_id: '',
      civility_id: '',
      birth_date: '',
      birth_dept: '',
      siren_number: '',
      siret_number: '',
      files: '',
    });
  }


  onSubmit() {
    const form = this.form.value;
    console.log(form)
     const formdata = new FormData();
    const client: Client = form;
    console.log(client);
    for (let file of this.files) {
      formdata.append("files", file);
    }
    formdata.append('client', JSON.stringify(client));
    console.log(formdata)
    this.clientService.createClient(formdata).subscribe(data => {
      console.log("onSubmit méthode réussie");
      console.log(data);
      this.created = true;
      this.client = data[0].context.client;
      this.clientService.client = this.client;
      console.log(this.client)
    }, error => {
      console.log(error);

    })

  }


  uploadFile(event) {
    for (let index = 0; index < event.length; index++) {
      const element = event[index];
      this.files.push(element)
    }
    console.log(this.files);
  }

  deleteAttachment(index) {
    this.files.splice(index, 1);
    if (this.files.length === 0){
      this.form.removeControl('files');
      this.form.addControl('files', new FormControl('', Validators.required));
    }
  }




  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      map(term => term === '' ? []
        :  this.classificationNatures.filter(v => v.classification_nature_label.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )
  formatter = (x: {classification_nature_label: string}) => x.classification_nature_label;

  searchDep = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term === '' ? []
        : departs.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )


}
