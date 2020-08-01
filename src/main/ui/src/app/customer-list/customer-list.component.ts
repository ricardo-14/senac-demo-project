import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  private customers: Customer[];

  private newCustomer: Customer;

  //private customerName: String;

  constructor() { }

  ngOnInit() {
    this.customers = customerCollection;
    this.newCustomer = new Customer();
  }

  onSubmit(customerForm: NgForm) {
    if (customerForm.valid) {
      this.customers.push(this.newCustomer);
      this.newCustomer = new Customer(); 
    }
  }
}

export class Customer {
  nome: String;
  data: String;
  email: String
}

export const customerCollection =[
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
