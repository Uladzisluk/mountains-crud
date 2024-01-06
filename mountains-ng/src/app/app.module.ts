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
import {PeakService} from "./peak/service/peak.service";
import { PeakViewComponent } from './peak/view/peak-view/peak-view.component';
import { PeakEditComponent } from './peak/view/peak-edit/peak-edit.component';
import {FormsModule} from "@angular/forms";
import { RangeCreateComponent } from './range/view/range-create/range-create.component';
import { RangeEditComponent } from './range/view/range-edit/range-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    MainComponent,
    NavComponent,
    RangeListComponent,
    PeakListComponent,
    PeakViewComponent,
    PeakEditComponent,
    RangeCreateComponent,
    RangeEditComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [RangeService, PeakService],
  bootstrap: [AppComponent]
})
export class AppModule { }
