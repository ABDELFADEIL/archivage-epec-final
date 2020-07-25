import {Component, Input, OnInit} from '@angular/core';
import {Document} from '../models/document';
import {Client} from '../models/client';
import {ClassificationNature} from '../models/classification-nature';
import {Router} from '@angular/router';
import {ClassificationNatureService} from '../service/classification-nature.service';
import {ClientService} from '../service/client.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {debounceTime, distinctUntilChanged, map} from 'rxjs/operators';
import {departs} from '../../environments/departs';
import {ContractService} from '../service/contract.service';
import {Contract} from '../models/contract';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-new-contract',
  templateUrl: './new-contract.component.html',
  styleUrls: ['./new-contract.component.css']
})
export class NewContractComponent implements OnInit {
  public files: File [] = [];
  public document: Document;
  public model;
  public modelDep;
  client: Client;
  public classificationNatures: ClassificationNature [] = [];
  public created: boolean;
  public clientId: number;
  final_business_processing_date: any;
  public contract: Contract;


  constructor(private contractService: ContractService, private clientService: ClientService, private router: Router, private  classificationNatureService: ClassificationNatureService) { }

  ngOnInit(): void {
    this.initializeFormGroup();
    this.getClassificationNature();
  }

  onSubmit() {
    const form = this.form.value;
    console.log(form)
    const formdata = new FormData();
    const cn: ClassificationNature = form.classification_nature;
    console.log(cn);
    let contract: Contract = new Contract();
    contract.contract_id_type_label = form.contract_id_type_label;
    contract.contract_id_type_code = form.contract_id_type_code;
    // contract.client = this.clientService.client;
    const final_business_processing_date = form.final_business_processing_date;
    console.log(contract);
    for (let file of this.files) {
      formdata.append("files", file);
    }
    formdata.append('classificationNature', JSON.stringify(cn));
    formdata.append('final_business_processing_date', JSON.stringify(final_business_processing_date));
    formdata.append('contract', JSON.stringify(contract));
    formdata.append('client', JSON.stringify(this.clientService.client));
    console.log(form);
    console.log(this.clientService.client);
    console.log(contract);

    this.contractService.createContract(formdata).subscribe(data => {
      console.log("onSubmit méthode réussie");
      this.created = true
      console.log(data);
      this.created = true;
      this.client = data[0].context.client;
      this.contract = data[0].context.contract;
      this.final_business_processing_date =  data[0].context.final_business_processing_date;
     // console.log(this.contract)

    }, error => {
      console.log(error);

    })


  }

  getClassificationNature() {
    this.classificationNatureService.getAll().subscribe(value => {
      this.classificationNatures = value;
    }, error => {
      console.log(error);
    })
  }

  form :FormGroup = new FormGroup({
    // client_id: new FormControl(null),
     contract_id_type_code: new FormControl('', Validators.required),
    contract_id_type_label: new FormControl(''),
    contract_number: new FormControl(''),
    files: new FormControl('', Validators.required),
    final_business_processing_date: new FormControl('', Validators.required),
    classification_nature: new FormControl(null, Validators.required)
  });

  initializeFormGroup() {
    this.form.setValue({
      contract_id_type_code: '',
      contract_id_type_label: '',
      contract_number: '',
      files: '',
      final_business_processing_date: '',
      classification_nature: ''
    });
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
