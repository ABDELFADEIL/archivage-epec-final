import {Component, OnInit, ViewChild} from '@angular/core';
import {ClientService} from '../../service/client.service';
import {Router} from '@angular/router';
import {Document} from '../../models/document';
import {ClassificationNatureService} from '../../service/classification-nature.service';
import {ClassificationNature} from '../../models/classification-nature';
import {NgbTypeahead} from '@ng-bootstrap/ng-bootstrap';
import {Observable, Subject, merge} from 'rxjs';
import {debounceTime, distinctUntilChanged, filter, map} from 'rxjs/operators';
import {Client} from '../../models/client';
import {FormControl, FormGroup, Validators} from '@angular/forms';




const departs = [
  "01 - Ain – Bourg-en-bresse", "02 - Aisne - Laon", "03 - Allier - Moulins", "04 - Alpes-de-Haute-Provence - Digne-les-bains",
  "05 - Hautes-alpes - Gap", "06 - Alpes-maritimes - Nice", "07 - Ardèche - Privas", "08 - Ardennes - Charleville-mézières", "09 - Ariège - Foix",
  "10 - Aube - Troyes", "11 - Aude - Carcassonne", "12 - Aveyron - Rodez", "13 - Bouches-du-Rhône - Marseille", "14 - Calvados - Caen", "15 - Cantal - Aurillac",
  "16 - Charente - Angoulême", "17 - Charente-maritime - La rochelle", "18 - Cher - Bourges", "19 - Corrèze - Tulle", "2a - Corse-du-sud - Ajaccio", "2b - Haute-Corse - Bastia",
  "21 - Côte-d'Or - Dijon", "22 - Côtes-d'Armor - Saint-brieuc", "23 - Creuse - Guéret", "24 - Dordogne - Périgueux", "25 - Doubs - Besançon", "26 - Drôme - Valence",
  "27 - Eure - Évreux", "28 - Eure-et-loir - Chartres", "29 - Finistère - Quimper", "30 - Gard - Nîmes", "31 - Haute-garonne - Toulouse", "32 - Gers - Auch",
  "33 - Gironde - Bordeaux", "34 - Hérault - Montpellier", "35 - Ille-et-vilaine - Rennes", "36 - Indre - Châteauroux", "37 - Indre-et-loire - Tours", "38 - Isère - Grenoble",
  "39 - Jura - Lons-le-saunier", "40 - Landes - Mont-de-marsan", "41 - Loir-et-cher - Blois", "42 - Loire - Saint-étienne", "43 - Haute-loire - Le puy-en-velay",
  "44 - Loire-atlantique - Nantes", "45 - Loiret - Orléans", "46 - Lot - Cahors", "47 - Lot-et-garonne - Agen", "48 - Lozère - Mende", "49 - Maine-et-loire - Angers",
  "50 - Manche - Saint-lô", "51 - Marne - Châlons-en-champagne", "52 - Haute-marne - Chaumont", "53 - Mayenne - Laval", "54 - Meurthe-et-moselle - Nancy", "55 - Meuse - Bar-le-duc",
  "56 - Morbihan - Vannes", "57 - Moselle - Metz", "58 - Nièvre - Nevers", "59 - Nord - Lille", "60 - Oise - Beauvais", "61 - Orne - Alençon", "62 - Pas-de-calais - Arras",
  "63 - Puy-de-dôme - Clermont-ferrand", "64 - Pyrénées-atlantiques - Pau", "65 - Hautes-Pyrénées - Tarbes", "66 - Pyrénées-orientales - Perpignan", "67 - Bas-rhin - Strasbourg",
  "68 - Haut-rhin - Colmar", "69 - Rhône - Lyon", "70 - Haute-saône - Vesoul", "71 - Saône-et-loire - Mâcon", "72 - Sarthe - Le mans", "73 - Savoie - Chambéry", "74 - Haute-savoie - Annecy",
  "75 - Paris - Paris", "76 - Seine-maritime - Rouen", "77 - Seine-et-marne - Melun", "78 - Yvelines - Versailles", "79 - Deux-sèvres - Niort", "80 - Somme - Amiens", "81 - Tarn - Albi",
  "82 - Tarn-et-garonne - Montauban", "83 - Var - Toulon", "84 - Vaucluse - Avignon", "85 - Vendée - La roche-sur-yon", "86 - Vienne - Poitiers",
  "87 - Haute-vienne - Limoges", "88 - Vosges - Épinal", "89 - Yonne - Auxerre", "90 - Territoire de belfort - Belfort", "91 - Essonne - Évry", "92 - Hauts-de-seine - Nanterre",
  "93 - Seine-Saint-Denis - Bobigny", "94 - Val-de-marne - Créteil", "95 - Val-d'oise - Pontoise", "971 - Guadeloupe - Basse-terre", "972 - Martinique - Fort-de-france",
  "973 - Guyane - Cayenne", "974 - La réunion - Saint-denis", "976 - Mayotte - Dzaoudzi", "99 - Etrager"
];


@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.css']
})
export class NewClientComponent implements OnInit {
  public files: File [] = [];
  public document: Document;
  public model;
  public modelDep;
  client: Client;

  @ViewChild('instance', {static: true}) instance: NgbTypeahead;
  focus$ = new Subject<string>();
  click$ = new Subject<string>();

  public classificationNatures: ClassificationNature [] = [];
  public created: boolean;
  public clientId: number;

  constructor(private clientService: ClientService, private router: Router, private  classificationNatureService: ClassificationNatureService) {
  }

  ngOnInit(): void {
    this.initializeFormGroup();
    this.getClassificationNature();
  }


    form :FormGroup = new FormGroup({
      // client_id: new FormControl(null),
      client_name: new FormControl('', [Validators.required, Validators.minLength(4)]),
      client_first_name: new FormControl('', [Validators.required, Validators.minLength(4)]),
      client_nature_id: new FormControl('', [Validators.required, Validators.minLength(1)]),
      civility_id: new FormControl('', [Validators.required, Validators.minLength(1)]),
      birth_date: new FormControl('', Validators.required),
      birth_dept: new FormControl('', Validators.required),
      siren_number: new FormControl(''),
      siret_number: new FormControl(''),
      files: new FormControl('', Validators.required),
      final_business_processing_date: new FormControl('', Validators.required),
      classification_nature: new FormControl(null, Validators.required)
    });

  initializeFormGroup() {
    this.form.setValue({
      client_name: '',
      client_first_name: '',
      client_nature_id: '',
      civility_id: '',
      birth_date: '',
      birth_dept: '',
      siren_number: '',
      siret_number: '',
      files: '',
      final_business_processing_date: '',
      classification_nature: ''
    });
  }


  onSubmit() {
    const form = this.form.value;
    console.log(form)
     const formdata = new FormData();
    const cn: ClassificationNature = form.classification_nature;
    console.log(cn);
    const client: Client = form;
    const final_business_processing_date = form.final_business_processing_date;
    console.log(client);
    for (let file of this.files) {
      formdata.append("files", file);
    }
    formdata.append('classificationNature', JSON.stringify(cn));
    formdata.append('final_business_processing_date', JSON.stringify(final_business_processing_date));
    formdata.append('client', JSON.stringify(client));
    console.log(formdata)
    this.clientService.createClient(formdata).subscribe(data => {
      console.log("onSubmit méthode réussie");
      console.log(data);
      this.created = true;
      this.client = data[0].context.client;
      console.log(this.client)
    }, error => {
      console.log(error);

    })

  }


  uploadFile(event) {
    for (let index = 0; index < event.length; index++) {
      const element = event[index];
      this.files.push(element)
    }
    console.log(this.files);
  }

  deleteAttachment(index) {
    this.files.splice(index, 1);
    if (this.files.length === 0){
      this.form.removeControl('files');
      this.form.addControl('files', new FormControl('', Validators.required));
    }
  }


  getClassificationNature() {
    this.classificationNatureService.getAll().subscribe(value => {
      this.classificationNatures = value;
    }, error => {
      console.log(error);
    })
  }

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      map(term => term === '' ? []
        :  this.classificationNatures.filter(v => v.classification_nature_label.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )
  formatter = (x: {classification_nature_label: string}) => x.classification_nature_label;

  searchDep = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term === '' ? []
        : departs.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )

}
