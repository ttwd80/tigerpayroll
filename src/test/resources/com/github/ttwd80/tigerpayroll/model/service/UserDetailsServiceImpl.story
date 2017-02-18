Given user configuration:
|username|roles|
|jackson||
|lucas|ROLE_USER|
|noah|ROLE_ADMIN|
|logan|ROLE_ADMIN, ROLE_USER|

When user jacob logs in
Then an exception is thrown

When user jackson logs in
Then there are no roles

When user lucas logs in
Then the user gets these roles:
|role|
|ROLE_USER|

When user noah logs in
Then the user gets these roles:
|role|
|ROLE_ADMIN|

When user logan logs in
Then the user gets these roles:
|role|
|ROLE_USER|
|ROLE_ADMIN|
