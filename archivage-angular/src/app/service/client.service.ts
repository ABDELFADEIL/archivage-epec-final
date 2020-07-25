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
}
