Description :
## Stack application : Which provides functionality to execute simple Stack operations like

1) get() - returns the top element from the stack
2) pop() - returns the top element and removes it from the stack, in case of Empty stack, It would through StackUnderflow Exception
3) push() - Inserts and element in the stack, returns true if the insertion was successful or throws and stackOverFlow Exception 
in case the stack is full

The size of the stack has been kept as a configuration in Application.properties file.

Application can be run using following command ```./gradlew bootRun```

## Api curls
```
url -X GET \
  http://localhost:8080/stack/peek \
  -H 'Postman-Token: 8f987100-0838-4f5b-ae4c-8f072ef01276' \
  -H 'cache-control: no-cache' 

```

```
curl -X DELETE \
  http://localhost:8080/stack/pop \
  -H 'Postman-Token: 9f5192cc-dc0b-4959-a80e-8d57a6be2d33' \
  -H 'cache-control: no-cache'
```

```
curl -X POST \
  http://localhost:8080/stack/push/123 \
  -H 'Postman-Token: 4f26308c-ae9f-4555-b4be-9dae58732942' \
  -H 'cache-control: no-cache'
```




