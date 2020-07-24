import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductsService } from './product-list/products.service';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { MeuPrimeiroComponent } from './meu-primeiro/meu-primeiro.componet';
import { MeuSegundoComponentComponent } from './meu-segundo-component/meu-segundo-component.component';
import { CustomerListComponent } from './customer-list/customer-list.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: ProductListComponent },
      { path: 'customers', component: CustomerListComponent },
      { path: 'products/:productId', component: ProductDetailsComponent },
    ])
  ],
  declarations: [
    AppComponent,
    TopBarComponent,
    ProductListComponent,
    MeuPrimeiroComponent,
    ProductDetailsComponent,
    MeuSegundoComponentComponent,
    CustomerListComponent
  ],
  bootstrap: [ AppComponent ],
  providers: [ProductsService]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/