import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { QuestionService } from 'src/app/services/question.service';

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.scss']
})
export class QuestionFormComponent implements OnInit {

  formTitle = 'Question form';
  form: FormGroup;
  submitted = false;
  options = [];
  question;

  constructor(
    private formBuilder: FormBuilder,
    private questionService: QuestionService,
    private toastr: ToastrService) {
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      title: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
      content: ['', Validators.compose([Validators.required])],
      category: ['', Validators.compose([Validators.required])],
      option: []
    });
  }

  onSubmit() {
    this.question = this.form.value;
    this.question.options = this.options;
    console.log(this.question);
    this.questionService.createQuestion(this.question).subscribe(resp => {
      this.toastr.info('Question saved with success');
    }, error => {
      this.toastr.error('Error saving the question');
    });
  }

  newOptionInput() {
    this.options.push({ value: this.form.value.option });
    this.form.get('option').setValue(null);
  }

  removeOption(option) {
    this.options = this.options.filter(opt => {
      return opt.value !== option.value;
    })
  }

}
