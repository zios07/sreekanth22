import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommentService {


  url = environment.API_URL;

  constructor(private http: HttpClient) { }

  saveComment(comment) {
    return this.http.post(this.url + '/comments', comment);
  }
}
