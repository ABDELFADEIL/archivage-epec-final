import {Client} from './client';

export class Contract {

    contact_id : number;
    contract_id_type_code : number;
    contract_id_type_label: string;
    client : Client;
    contract_number : string;
    creating_date : Date;
    constructor() {
    }
}
