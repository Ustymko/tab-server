# TAB Documentation
Base url: https://tabservertest.azurewebsites.net/

## Users table:
1. GET (all users)
Url:  https://tabservertest.azurewebsites.net/users/all
2. GET (by id)
Url:   https://tabservertest.azurewebsites.net/users/get/{id}
3. POST
Url:  https://tabservertest.azurewebsites.net/users/post
Body:
{
"id": int,
"username": str,
"isBot": bool
}
4. PUT (by id)
Url:  https://tabservertest.azurewebsites.net/users/put/{id}
Body:
{
"id": int,
"username": str,
"isBot": bool
}
5. DELETE (by id)
Url:  https://tabservertest.azurewebsites.net/users/delete/{id}


## Groups table:
1. GET (all groups)
Url:  https://tabservertest.azurewebsites.net/groups/all
2. GET (by id)
Url:  https://tabservertest.azurewebsites.net/groups/get/{id}
3. POST
Url:  https://tabservertest.azurewebsites.net/groups/
Body:
{
"id": int,
"name": some_name: str
}
4. PUT (by id)
Url:  https://tabservertest.azurewebsites.net/groups/put/{id}
Body:
{
"id": int,
"name": str
}
5. DELETE (by id)
Url:  https://tabservertest.azurewebsites.net/groups/delete/{id}


## Messages table:
1. GET (all messages)
Url:  https://tabservertest.azurewebsites.net/messages/all
2. GET (by id)
Url:  https://tabservertest.azurewebsites.net/messages/get/{id}
3. POST
Url:  https://tabservertest.azurewebsites.net/messages/post/
Body:
{
  "id": int,
  "isAdvertisement": null or bool value,
  "messageBody": str,
  "sendDate": "2018-12-10T13:49:51.141Z" : timestamp,
  "group": {
"id": (in group table):  int,
"name": str
},
  "user": {
"id": (in user table): int,
"username": str,
"isBot": bool
}
}
4. PUT (by id)
Url: https://tabservertest.azurewebsites.net/messages/put/{id}
Body:
{
  "messageId": some_id: int,
  "isAdvertisement": null or bool value,
  "messageBody": some_message_body: str,
  "sendDate": "2018-12-10T13:49:51.141Z" : timestamp,
  "group": {
"id": (in group table):  int,
"name": str
},
  "user": {
"id": (in user table): int,
"username": str,
"isBot": bool
}
}
5. DELETE (by id)
Url: https://tabservertest.azurewebsites.net/messages/delete/{id}
 

## Admin chat table:
1. GET (all chats and their admins):
Url: https://tabservertest.azurewebsites.net/admin/chat
2. GET (chat by id)
Url: https://tabservertest.azurewebsites.net/admin/chat/get_chat/{id}
3. POST (chat with admins)
Url: https://tabservertest.azurewebsites.net/admin/chat
Body:
{"id": int,
 "title": str,
 "admins": [
   {
 	"id": id_of_user(not a foreign key): int
   },
   {
 	"id": id_of_user(not a foreign key): int
   },
…
 ]}
