import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListAllCountryComponent } from './list-all-country/list-all-country.component';

const routes: Routes = [
  {path: "", component: ListAllCountryComponent, pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
