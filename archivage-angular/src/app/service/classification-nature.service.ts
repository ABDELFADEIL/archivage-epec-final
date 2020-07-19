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

  getAll() :Observable<ClassificationNature []>{
   return this.httpClient.get<ClassificationNature []>(environment.apiUrl+"/api/classificationNatures/get-all-classificationNature");
  }

  update(classificationNature:ClassificationNature) {
    return this.httpClient.put(environment.apiUrl+"/api/classificationNatures/update-one", classificationNature);
  }

  delete(classificationNatureId: any) {
   return this.httpClient.delete(environment.apiUrl+ "/api/classificationNatures/delete-one?classificationNatureId="+classificationNatureId);
  }

  create(classificationNature: ClassificationNature) {
    return this.httpClient.post(environment.apiUrl+"/api/classificationNatures/create-classificationNature", classificationNature);
  }

  getByKeyWord(keyWord: any) {
    return this.httpClient.get<ClassificationNature []>(environment.apiUrl+"/api/classificationNatures/get-all-classificationNature-keyWord?keyword="+keyWord);
  }
}
