import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { MainComponent } from './component/main/main.component';
import { NavComponent } from './component/nav/nav.component';
import { RangeListComponent } from './range/view/range-list/range-list.component';
import {HttpClientModule} from "@angular/common/http";
import {RangeService} from "./range/service/range.service";
import { PeakListComponent } from './peak/view/peak-list/peak-list.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    MainComponent,
    NavComponent,
    RangeListComponent,
    PeakListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [RangeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
