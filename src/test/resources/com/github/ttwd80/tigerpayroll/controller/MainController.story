Given login configuration:
|role|view|
|ROLE_ADMIN|redirect:/admin/index|
|ROLE_USER|redirect:/user/index|

When user is in role ROLE_ADMIN
Then the user should see view redirect:/admin/index

When user is in role ROLE_USER
Then the user should see view redirect:/user/index
