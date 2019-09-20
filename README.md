HTML을 PDF변환을 할수있는 여러 오픈소스들 다 적용해보았다.
한글변환, CSS 적용, 이미지적용 등 모든 요건을 완벽하게 처리 가능한 오픈소스는 존재하지않았다.

org.w3c.tidy를 이용해 html -> xhtml로 변환
flying saucer를 이용해 xhtml -> pdf로 변환 처리했다.

적용되는 CSS는 css-inline 툴로 inline 처리하고
폰트는 예제 class를 보면 된다.

이미지 처리는 request 자체가 img인것으로 바로 처리되나 request가 doc이고 response가 img 인경우
base64인코딩으로 처리했다.

# freeHtmlToPdf
#무료HTMLtoPDF변환소스
