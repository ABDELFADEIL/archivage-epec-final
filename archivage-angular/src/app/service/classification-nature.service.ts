import { Injectable } from '@angular/core';
import {ClassificationNature} from '../models/classification-nature';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environment';

@Injectable({
  providedIn: 'root'
})
export class ClassificationNatureService {

  constructor(private httpClient: HttpClient) { }

  getAll() {
   return this.httpClient.get(environment.apiUrl+"/api/classificationNatures/get-all-classificationNature");
  }

  update(classificationNature:ClassificationNature) {
    return this.httpClient.put(environment.apiUrl+"/api/classificationNatures/update-one", classificationNature);
  }

  delete(id: any) {
   return this.httpClient.delete(environment.apiUrl+ "/api/classificationNatures/delete-one?classificationNatureId="+id);
  }
}
