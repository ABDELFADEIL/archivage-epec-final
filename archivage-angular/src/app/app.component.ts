import {Component, ElementRef, HostListener, Renderer2, ViewChild} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {filter, map, mergeMap} from 'rxjs/operators';
import {Title} from "@angular/platform-browser";
import {AppService} from './appService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title ;
  toggle:string;
  // titleAfiche:string;
 supTitle: string;
  @ViewChild('tog') toggleButton: ElementRef;
 // @ViewChild('menu') menu: ElementRef;
  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              private renderer: Renderer2, private titleService: Title, public appService:AppService, private _eref: ElementRef) {
    const appTitle = this.titleService.getTitle();

    this.router
      .events.pipe(
      filter(event =>
        event instanceof NavigationEnd),
      map(() => {
       // this.supTitle = this.activatedRoute;
        const child = this.activatedRoute.firstChild;
        if (child.snapshot.data['title']) {
          return child.snapshot.data['title'];
        }
        return appTitle;
      })

    ).subscribe(ttl => {
      console.log("appTitle "+ttl)

      this.titleService.setTitle(ttl);
      this.title = this.titleService.getTitle();

    });

    renderer.listen('document', 'click', (event) => {
      this.toggle = event.target.className;
      if (!this.toggle.startsWith('dropdown-toggle')){
        this.toggleNavbar();
      }

    });

  }



  public clicked = false;
  _el: any;
  sidbarOpenClients: boolean = false;
  sidbarOpenContracts: boolean = false;
  sidbarOpenAccounts: boolean = false;


  ngOnInit(): void {}

  onClick(event): void {
    event.preventDefault();
    event.stopPropagation();
    this.clicked = true;



  }

  @HostListener('document:click', ['event'])

  private clickedOutside(event): void {
    if (this.clicked) {
      this._el.nativeElement.querySelector('.dropdown-menu').classList.toggle(['show', 'side']);

    }}


  toggleNavbarClients() {
    this.sidbarOpenClients = !this.sidbarOpenClients;
    this.sidbarOpenContracts = false;
    this.sidbarOpenAccounts = false;
  }
  toggleNavbar() {
    if (this.sidbarOpenClients){
      this.sidbarOpenClients = false;
    }
    if (this.sidbarOpenContracts) {
      this.sidbarOpenContracts = false;
    }
    if (this.sidbarOpenAccounts){
      this.sidbarOpenAccounts = false;
    }
  }

  toggleNavbarContracts() {
    this.sidbarOpenContracts = !this.sidbarOpenContracts;
    this.sidbarOpenAccounts = false;
    this.sidbarOpenClients = false;
  }
  toggleNavbarAccounts() {
    this.sidbarOpenAccounts = !this.sidbarOpenAccounts;
    this.sidbarOpenClients = false;
    this.sidbarOpenContracts = false;
  }


}
