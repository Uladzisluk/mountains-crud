import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RangeListComponent} from "./range/view/range-list/range-list.component";

const routes: Routes = [
  {
    component: RangeListComponent,
    path: "ranges"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
