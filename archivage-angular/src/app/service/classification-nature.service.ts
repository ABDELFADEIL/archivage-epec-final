import { Injectable } from '@angular/core';
import {ClassificationNature} from '../models/classification-nature';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClassificationNatureService {

  constructor(private httpClient: HttpClient) { }

  getAll(page) :Observable<ClassificationNature []>{
   return this.httpClient.get<ClassificationNature []>(environment.apiUrl+"/api/classificationNatures/get-all-classificationNature?page="+page+"&size="+12);
  }

  update(classificationNature:ClassificationNature) {
    return this.httpClient.put(environment.apiUrl+"/api/classificationNatures/update-one", classificationNature);
  }

  delete(id: any) {
   return this.httpClient.delete(environment.apiUrl+ "/api/classificationNatures/delete-one?classificationNatureId="+id);
  }
}
