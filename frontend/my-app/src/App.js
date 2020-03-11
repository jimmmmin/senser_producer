import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'
import PersonalPage from "./component/PersonalPage";
import login from "./component/login";
import {Route, Link} from "react-router-dom";
import customAxios from "./customAxios";
//import TopMenuComponent from "./TopMenuComponent";

function App() {
    //IP주소 변수 선언
    const [ip, setIp] = useState('');

    //IP주소 값을 설정
    function callback(data) {
        setIp(data);
    }

    // 첫번째 렌더링을 다 마친 후 실행합니다.
    useEffect(
        () => {
            // 클라이언트의 IP주소를 알아내는 백엔드의 함수를 호출합니다.
            customAxios('/ip', callback);
        }, []
    );

  return (
      <div>
          <header className="App-header">
              이 기기의 IP주소는 {ip}입니다.
          </header>
          <div>
              <ul>
                  <li>
                      <Link to="/personal" exact={true} >myPage</Link>
                  </li>
                  <li>
                      <Link to="/logIn" exact={true} >login</Link>
                  </li>
              </ul>
          </div>
           <Route path="/personal" component={PersonalPage} exact={true} />
           <Route path="/logIn" component={login} exact={true} />
      </div>

  );
}




export default App;
