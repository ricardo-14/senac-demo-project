import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  private customers: Customer[];

  private customerName: String;

  constructor() { }

  ngOnInit() {
    let customerA = new Customer();
    

    this.customers = [
      customerA,
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
  }

  onSubmit(customerForm: NgForm, customerName:String, data:String, email:String) {
    if (customerForm.valid) {
      let newCustomer = new Customer();
      newCustomer.nome = customerName;
      newCustomer.data = data;
      newCustomer.email = email;
      this.customers.push(newCustomer);
    }
  }
}

export class Customer {
  nome: String;
  data: String;
  email: String
}
