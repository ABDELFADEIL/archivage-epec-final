import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.css']
})
export class NewClientComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(form){
    console.log("onSubmit méthode"+ form.value)
  }
}
