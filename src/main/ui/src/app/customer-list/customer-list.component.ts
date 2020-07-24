import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers = [
{
  nome: "Ricardo",
  data: "14/11/01",
  email: "ricardo@email.com"
},
{
  nome: "Gabriel",
  data: "02/09/03",
  email: "gabriel@email.com"
},
{
  nome: "Lucas",
  data: "02/05/03",
  email: null
}
];

  constructor() { }

  ngOnInit() {
  }

}
