import { HTTP_INTERCEPTORS, HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule, MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatDatepickerModule, MatDialogModule, MatGridListModule, MatIconModule, MatInputModule, MatMenuModule, MatNativeDateModule, MatPaginatorModule, MatProgressSpinnerModule, MatRadioModule, MatSelectModule, MatTableModule, MatTabsModule, MatToolbarModule, MatTooltipModule, MatListModule } from '@angular/material';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { ToastrModule } from 'ngx-toastr';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/common/footer/footer.component';
import { HomeComponent } from './components/common/home/home.component';
import { LoginComponent } from './components/common/login/login.component';
import { NavComponent } from './components/common/nav/nav.component';
import { RegisterComponent } from './components/common/register/register.component';
import { HttpInterceptorService } from './interceptors/http-interceptor.service';
import { QuestionFormComponent } from './question/question-form/question-form.component';
import { QuestionViewComponent } from './question/question-view/question-view.component';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    QuestionFormComponent,
    QuestionViewComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatTooltipModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatToolbarModule,
    MatCardModule,
    MatTableModule,
    MatMenuModule,
    MatTabsModule,
    MatPaginatorModule,
    MatDialogModule,
    MatGridListModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonToggleModule,
    MatCheckboxModule,
    MatListModule,
    ToastrModule.forRoot(),
    MDBBootstrapModule.forRoot()
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
