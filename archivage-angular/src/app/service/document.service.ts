import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ClassificationNature} from '../models/classification-nature';
import {environment} from '../environment';
import {Document} from '../models/document';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  constructor(private httpClient: HttpClient) { }

  getAllDocs() {
    return this.httpClient.get<Document []>(environment.apiUrl+"/api/documents/all-docs-infos");
  }

  getDocById() :Observable<Document []>{
    return this.httpClient.get<Document []>(environment.apiUrl+"/api/documents/get-doc-by-id?docId");
  }

  updateDocContext( docID,  context) {
    return this.httpClient.put(environment.apiUrl+"/api/documents/update-doc-context-by-doc-id?docID="+docID, context);
  }

  delete(id: any) {
    return this.httpClient.delete(environment.apiUrl+ "/api/documents/delete-one?docID="+id);
  }

  getAllDocsEventTypeBeforeDate(since: string) {
    return this.httpClient.get<any[]>(environment.apiUrl+"/api/documents/search-docs-fbpd-null-since?since="+since);

  }
}
