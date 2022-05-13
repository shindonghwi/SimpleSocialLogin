# SimpleSocialLogin

### 현재 제공하는 소셜 로그인: [ 카카오, 구글 ]
<br/><br/>

## Preview
  Kakao Login    |    Google Login   |
:-------------------------:|:--------------------------:|
 ![kakao](https://user-images.githubusercontent.com/45490440/168224077-c6da4526-41e0-48c8-b3b5-21c3917a4bf0.gif) | ![google](https://user-images.githubusercontent.com/45490440/168224093-731fa410-a497-4c6d-b60c-ab224db6d9f1.gif)


<br/><br/>



## Usage

### 1. File Create
![image](https://user-images.githubusercontent.com/45490440/168222574-2714b3e0-1447-4566-a829-45355233ee58.png)
```
파일 위치: Project Root
```

### 2. Social Key 작성

property에 키 정보를 담으면서 "" 여부가 중요하다.
아래 "" 가 붙어야 하는것고 아닌 것이 있다. 아래 예시를 잘 보고 작성하자.

```
kakao.sdk.appkey="카카오 앱 키" => (""필수)
kakao.sdk.nativekey=kakao카카오 앱 키 => (""붙으면안됨)
google.client.id="Google Client Id" => (""필수)
```
<br/><br/>

## License 
 ```code
Copyright 2022 ShinDongHwi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
