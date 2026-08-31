# hello-world

Application source for hello-world Lambda demos. Infrastructure lives in [hello-world-iac](https://github.com/singharpit2209/hello-world-iac).

## Apps

| Folder | Component | Runtime |
|---|---|---|
| `hello-world-python/` | `python` | Python 3.12 |
| `hello-world-node/` | `node` | Node.js 20 |
| `hello-world-java/` | `java` | Java 21 |

## GitHub variables (only two)

| Variable | Value |
|---|---|
| `AWS_REGION` | `us-east-1` |
| `AWS_ROLE_ARN` | `app-cd-deployer` role ARN |

Deploy targets are **computed from the naming contract** — no `HELLO_*` function or bucket variables.

## CI/CD

- **Push** to a component folder → build + test
- **Manual dispatch** with `deploy: true` → build + deploy to Lambda `live` alias

Naming (must match hello-world-iac):

```text
function = singharpit2209-iac-hello-world-{component}-{environment}
bucket   = singharpit2209-iac-hello-world-{component}-artifacts-{environment}
```

## E2E

1. Apply hello-world-iac (environment `dev`)
2. `terraform output lambda_deploy_targets` for API URLs
3. Run **hello-world-python** workflow with `deploy: true`
4. Curl the python `api_endpoint` from Terraform output
