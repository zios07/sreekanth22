import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { QuestionService } from 'src/app/services/question.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  questions;

  constructor(
    private auth: AuthenticationService,
    private questionService: QuestionService,
    private toastr: ToastrService) { }

  ngOnInit() {
    if (this.auth.isAuthenticated()) {
      this.loadQuestions();
    }
  }

  loadQuestions() {
    this.questionService.loadQuestions().subscribe(resp => {
      this.questions = resp;
    })
  }

}
