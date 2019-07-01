import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CommentService } from 'src/app/services/comment.service';
import { QuestionService } from 'src/app/services/question.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-question-view',
  templateUrl: './question-view.component.html',
  styleUrls: ['./question-view.component.scss']
})
export class QuestionViewComponent implements OnInit {

  form: FormGroup;
  question;
  loading = false;

  constructor(private formBuilder: FormBuilder, private userService: UserService,
    private route: ActivatedRoute, private questionService: QuestionService, private toastr: ToastrService,
    private commentService: CommentService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      comment: []
    });
    this.getQuestion();
  }

  getQuestion() {
    this.loading = true;
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.questionService.findById(id).subscribe((result: any) => {
        this.question = result;
        this.loading = false;
      }, error => {
        this.toastr.error(String(error));
      });
    }
  }

  onSubmit() {
    this.userService.getAuthenticatedUser().subscribe((resp: any) => {
      const comment: any = {};
      comment.value = this.form.get('comment').value;
      comment.date = new Date();
      comment.question = this.question;
      comment.user = resp;
      this.commentService.saveComment(comment).subscribe(() => {
        this.toastr.info('comment sent successfully');
        this.getQuestion();
      });
    });
  }

}
