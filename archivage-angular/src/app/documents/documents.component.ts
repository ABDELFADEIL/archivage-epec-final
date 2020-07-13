import { Component, OnInit } from '@angular/core';
import {DocumentService} from '../service/document.service';
import { observe } from "rxjs-observe";


@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html',
  styleUrls: ['./documents.component.css']
})
export class DocumentsComponent implements OnInit {

  documents: Document [];
  public page : number = 1;
  public size : number= 12;
  public currentSize : number;
  currentPage : number = 1;
  public totalPages: number;
  public pages: number[];

  constructor(private documentService: DocumentService) {
    this.getAllDocs();
  }

  ngOnInit(): void {

  }

  getAllDocs(){
    console.log("docs initialés ::::: ");
    this.documentService.getAllDocs().
    subscribe(value => {
      console.log("docs ::::: ");
      // this.totalPages=value["totalPages"];
      // this.pages= new Array<number>(this.totalPages);
      this.documents= value;
    }, error => {
      console.log(error);
    })
  }


  onDelete(classification_nature_id: any) {
    
  }

  update(c: any) {
    
  }

  getAllDocsPage(page: number) {
    
  }
}
