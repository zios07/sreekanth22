import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  url = environment.API_URL + '/questions';

  constructor(private http: HttpClient) { }

  loadQuestions() {
    return this.http.get(this.url);
  }

  findById(id) {
    return this.http.get(this.url + '/' + id);
  }

  createQuestion(post) {
    return this.http.post(this.url, post);
  }
}
