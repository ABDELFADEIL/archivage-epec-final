import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {
   public title = "Accounts";
  private supTitle: string;
  constructor() { }

  ngOnInit(): void {this.supTitle = "comptes"

  }

  onSubmit(f){
    console.log(f.value);
  }
}
