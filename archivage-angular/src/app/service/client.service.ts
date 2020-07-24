import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environment';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient : HttpClient) { }

  createClient(form: FormData) {
    return this.httpClient.post(environment.apiUrl+"/api/clients/new-client-with-docs", form);
  }
}
