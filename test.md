[intro]: #!/search/text/_id/123 "read SABIO 5 API introduction"
[authentication]: #!/search/text/_id/123 "definition of authentication interface"
[text]: #!/search/text/_id/123 "definition of text interface"
[tree]: #!/search/text/_id/123 "definition of tree interface"
[branch]: #!/search/text/_id/123 "definition of branch interface"
[user]: #!/search/text/_id/123 "definition of user interface"

[further_reading]: #further_reading "jump to list of defined interfaces"
[resource_list]: #ResourceList "jump to definition of ResourceListContainer"
[rfc822]: http://www.ietf.org/rfc/rfc0822.txt "read RFC822"



*This document describes the SABIO 5 authentication service. For general informations about the API read the [introduction][intro].*

---

##Authentication##

| URL     | `/authentication`
|:--------|:-----------------
| Access  | public
| Methods | `POST`, `DELETE`


Interface to authenticate a user and return an authentication token.

The interface supports three types of authentication: with credentials, by an already existing token or via SSO. The genereated token has to be send as `sabio-auth-token` header in each request that requires a user. In some cases the token needs to be appended as a `sabio-auth-token` query parameter (e.g. when downloading documents).

###JSON Format###

| Name         | Type     | Writable | Required | Description
|:-------------|:---------|:---------|:---------|:-----------
| realm        | String   | yes      | no       | This property will be auto-detected from the request URL if omitted.
| type         | String   | yes      | yes      | Authentication type. Possible values are `credentials`, `token` or `sso`.
| key          | String   | yes      | no       | Represents the user's password when `type` is set to `credentials` or the token when `type` is set to `token`. This field can be omitted when `type` is set to `sso`. The server will use this property to return the token.
| login        | String   | yes      | no       | Represents the user's login name when `type` is set to `credentials`.
| persistent   | Boolean  | yes      | no       | Tells the server to create a persistent token.
| fullResponse | Boolean  | yes      | no       | Tells the server to return all user informations that are required for initializing a frontend application, including available features, permissions, etc. This is not needed for basic user authentication.
| user         | User     | no       | no       | A resource representing the authenticated [user]. Only returned when `fullResponse` is set to `true`.
| privileges   | Object   | no       | no       | An object containing the user's privileges. The object key represents the SABIO 5 resource name, the value an array of available privilege names. Only returned when `fullResponse` is set to `true`.
| state        | Object   | no       | no       | Contains informations about the user's GUI state. Only returned when `fullResponse` is set to `true`.
| styles       | String   | no       | no       | Custom styles defined for the realm. Only returned when `fullResponse` is set to `true`.
| branches     | Array    | no       | no       | Array of all [branches][branch] available for the user. Only returned when `fullResponse` is set to `true`.
| system       | Object   | no       | no       | An object containing the realm's configuration. 

###Example###

Authentication request using credentials:
```json
{
    "type": "credentials",
    "login": "soeren",
    "key": "password1",
    "fullResponse": true
}
```

Response data of successfull authentication and `fullResponse` set to `true`:
```json
{
    "type": "credentials",
    "fullResponse": true,
    "key": "vTJR3vPSZa58GKpu4oHKm1h...%0A",
    "user": <User>,
    "branches": [<Branch>],
    "privileges": {
        "message": ["read"],
        "text": ["create","read","update","delete"]
    },
    "styles": <String>,
    "system": <Object>
}
```
