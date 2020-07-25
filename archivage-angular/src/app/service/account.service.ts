import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environment';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient : HttpClient) { }


  createContract(form: FormData) {
    return this.httpClient.post(environment.apiUrl+"/api/contracts/new-contract-with-docs", form);
  }

}
