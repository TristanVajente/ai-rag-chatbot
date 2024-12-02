import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, HttpClientModule, NgIf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'chatbot';
  userInput: String = "";
  aiResponse: String = "";
  historyId: String | undefined = undefined;

  constructor(private readonly httpClient: HttpClient) {
  }

  onClick() {
    console.log("User input: ", this.userInput);
    this.httpClient.post<UserChatResponse>(
      "http://localhost:8080/api/v1/chat",
      {
        "userPrompt": this.userInput,
        "historyId": this.historyId
      }
    ).subscribe(it => {
      this.aiResponse = it.response;
      this.historyId = it.historyId
    })
  }
}

interface UserChatResponse {
  historyId: String,
  response: String,
}
