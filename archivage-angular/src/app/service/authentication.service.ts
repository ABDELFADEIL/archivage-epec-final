import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtHelper } from 'angular2-jwt';
import "rxjs/Rx"
import { Router } from '@angular/router';
import {User} from '../models/user';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  host: string = "http://localhost:8080";
  jwtToken: string;
  roles: Array<any> = [];
  public user: Observable<User>;




  constructor(private http: HttpClient, private router:Router)
  {
      this.jwtToken = this.loadToken();

  }

  login(user) {
    return  this.http.post(this.host + "/login", user, { observe: 'response' });
  }


  saveToken(jwtToken) {
    this.jwtToken = jwtToken;
    localStorage.setItem('jwtToken', jwtToken);
    let jwtHelper = new JwtHelper();
    this.roles = jwtHelper.decodeToken(this.jwtToken).roles;
    // this.email = jwtHelper.decodeToken(this.jwtToken).sub;


  }

  loadToken() {
    this.jwtToken = localStorage.getItem('jwtToken');
    return this.jwtToken;
  }

  register(user) {
    return this.http.post(this.host+ "/persons/create-person", user);
  }


  logout(){
    this.jwtToken= null;
    localStorage.removeItem('jwtToken');
    this.user = null;
    this.router.navigateByUrl('/login');
  }

  isAdmin(){
    let jwtHelper=new JwtHelper();
    this.jwtToken= localStorage.getItem('jwtToken');
    if (this.jwtToken){
      this.roles=jwtHelper.decodeToken(this.jwtToken).roles;
      for(let r of this.roles) {
        if(r.authority=='ADMIN'){
          return true;
        }
      }
    }

  }


  getUserInfo(){
    if(this.jwtToken==null)
      this.jwtToken = this.loadToken();
    return this.http.get(this.host+"/api/users/user-info",  {headers:new HttpHeaders({'authorization':this.jwtToken})});
  }


}
