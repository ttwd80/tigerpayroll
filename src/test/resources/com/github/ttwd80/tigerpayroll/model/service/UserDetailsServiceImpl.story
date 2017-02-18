Given user configuration:
|username|roles|
|jackson||
|lucas|ROLE_USER|
|noah|ROLE_ADMIN|
|logan|ROLE_ADMIN, ROLE_USER|

When user jacob logs in
Then an exception is thrown
