import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environment';
import {Client} from '../models/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  public client: Client;

  constructor(private httpClient : HttpClient) { }

  createClient(form: FormData) {
    return this.httpClient.post(environment.apiUrl+"/api/clients/new-client-with-docs", form);
  }

  searchClientByNameOrNumberClient(client_name: string, client_number: number) {
    return this.httpClient.get<Client[]>(environment.apiUrl+"/api/clients/get-clients-by-client-name-number?client_name="+client_name+"&client_number="+client_number);

  }
}
