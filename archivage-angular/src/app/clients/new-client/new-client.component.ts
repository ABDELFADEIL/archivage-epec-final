import { Component, OnInit } from '@angular/core';
import {ClientService} from '../../service/client.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.css']
})
export class NewClientComponent implements OnInit {
  public files: File []  =  [] ;

  constructor(private clientService : ClientService, private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit(form){
    console.log(form);
    console.log(this.files);
    const formdata = new FormData();
    /*
    for (let file of this.files) {
      formdata.append('files[]', file );
    }
     */
    for (let file of this.files){
      formdata.append("files", file);
    }
    formdata.append('client', JSON.stringify(form));
    console.log(formdata)
    this.clientService.createClient(formdata).subscribe(data=> {
      console.log("onSubmit méthode réussie");
      console.log(data);
      this.router.navigateByUrl('')
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
    this.files.splice(index, 1)
  }

}
