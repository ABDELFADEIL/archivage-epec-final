import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {ClientService} from '../service/client.service';
import {Router} from '@angular/router';
import {ClassificationNature} from '../models/classification-nature';
import {Client} from '../models/client';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  clients: Client [] = [];
  public page : number = 1;
  public size : number= 12;
  public currentSize : number;
  currentPage : number = 1;
  public totalPages: number;
  public pages: number[];
  public keyword;
  public client : Client;
  public client_name;
  public client_number;
  chercher: boolean =false;
  create: boolean= false;

  constructor(private clientService: ClientService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(client_name, client_number) {

    this.chercher = true
    if (client_name==''){
      this.client_name = null;
    } else{
      this.client_name = client_name
    }
    if (client_number == ''){
      this.client_number = null;
    }else {
      this.client_number = client_number;
    }

    console.log(client_name)
    console.log(client_number)

    this.clientService.searchClientByNameOrNumberClient(this.client_name, this.client_number).subscribe(data => {
      console.log(data)
      this.clients = data;
    }, error => {
      console.log(error)
    })
  }





  getAllClients() {
    this.onSubmit(this.client_name, this.client_number);
  }

  onAddAccountOrContract(c: Client) {
    this.client = c;
    this.create = true
   // this.router.navigateByUrl('/new-client')
  }
}
