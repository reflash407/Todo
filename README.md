# Todo List API 명세


##  1. Todo 작성

###  요청
**POST** `/todo`

####  요청 본문 (JSON)
```json
{
  "title": "제목1",
  "content": "내용1"
}
```

###  응답

#### ✅ 성공 (200)
```json
{
    "code": 200,
    "message": "Todo 생성 완료",
    "data": {
        "id": 0
    }
}
```

#### ❌ 실패 (400) - 필수 값이 입력되지 않은 경우
```json
{
    "status": 400,
    "message": "필수 값이 없습니다."
}
```

---

##  2. 전체 Todo 리스트 조회

###  요청
**GET** `/todo`

###  응답

#### ✅ 성공 (200)
```json
{
    "code": 200,
    "message": "Todo 전체 조회",
    "data": [
        {
            "title": "title4",
            "content": "todo4 입니다."
        },
        {
            "title": "title5",
            "content": "todo5 입니다."
        }
    ]
}
```

---

##  3. 특정 Todo 조회

###  요청
**GET** `/todo/{id}`

###  응답

#### ✅ 성공 (200)
```json
{
    "code": 200,
    "message": "Todo 조회",
    "data": {
        "title": "title5",
        "content": "todo5 입니다."
    }
}
```

#### ❌ 실패 (404) - 해당 ID의 Todo가 존재하지 않는 경우
```json
{
    "status": 404,
    "message": "Todo를 찾을 수 없습니다."
}
```

---

##  4. Todo 제목 수정

###  요청
**PUT** `/todo/{id}`

####  요청 본문 (JSON)
```json
{
    "title": "수정된 title"
}
```

###  응답

#### ✅ 성공 (200)
```json
{
    "code": 200,
    "message": "업데이트에 성공하였습니다.",
    "data": {
        "title": "수정된 titleeee",
        "content": "todo4 입니다."
    }
}
```

#### ❌ 실패 (400) - 중복된 제목인 경우
```json
{
    "status": 400,
    "message": "중복된 값입니다."
}
```

---

##  5. Todo 삭제

###  요청
**DELETE** `/todo/{id}`

###  응답

#### ✅ 성공 (200)
```json
{
    "code": 200,
    "message": "삭제가 완료되었습니다.",
    "data": {
        "id": 0
    }
}
```

#### ❌ 실패 (404) - 해당 ID의 Todo가 존재하지 않는 경우
```json
{
    "status": 404,
    "message": "Todo를 찾을 수 없습니다."
}
```
