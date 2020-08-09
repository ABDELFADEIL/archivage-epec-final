import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environment';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient : HttpClient) { }


  createAccount(form: FormData) {
    return this.httpClient.post(environment.apiUrl+"/api/accounts/create-new-account-with-docs", form);
  }

}
