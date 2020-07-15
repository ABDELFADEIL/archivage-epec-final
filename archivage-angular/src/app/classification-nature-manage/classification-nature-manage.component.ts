import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-classification-nature-manage',
  templateUrl: './classification-nature-manage.component.html',
  styleUrls: ['./classification-nature-manage.component.css']
})
export class ClassificationNatureManageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(form) {
  console.log(form.value)
  }

}
