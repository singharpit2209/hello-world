# hello-world

Application source for three hello-world Lambda demos. Infrastructure lives in [`hello-world-iac`](https://github.com/singharpit2209/hello-world-iac).

## Apps

| Folder | Runtime | Build workflow |
|---|---|---|
| `hello-api-python/` | Python 3.12 | `build-python.yml` |
| `hello-api-node/` | Node.js 20 | `build-node.yml` |
| `hello-api-java/` | Java 21 | `build-java.yml` |

## GitHub variables

Use the **`app-cd-deployer`** role ARN from `roles-iac` output (`deploy_role_arns.app-cd-deployer`).

| Variable | Example (after IaC apply) |
|---|---|
| `AWS_REGION` | `us-east-1` |
| `AWS_ROLE_ARN` | `arn:aws:iam::371281943190:role/singharpit2209-iac-gha-app-cd-deployer-dev` |
| `HELLO_API_PYTHON_LAMBDA_FUNCTION_NAME` | `singharpit2209-iac-hello-api-python-dev` |
| `HELLO_API_PYTHON_ARTIFACT_BUCKET` | `singharpit2209-iac-hello-api-python-artifacts-dev` |
| `HELLO_API_NODE_LAMBDA_FUNCTION_NAME` | `singharpit2209-iac-hello-api-node-dev` |
| `HELLO_API_NODE_ARTIFACT_BUCKET` | `singharpit2209-iac-hello-api-node-artifacts-dev` |
| `HELLO_API_JAVA_LAMBDA_FUNCTION_NAME` | `singharpit2209-iac-hello-api-java-dev` |
| `HELLO_API_JAVA_ARTIFACT_BUCKET` | `singharpit2209-iac-hello-api-java-artifacts-dev` |

## CI/CD

- **Push** to an app folder runs build + tests only.
- **Manual dispatch** with `deploy: true` runs build then `deploy-lambda.yml` (updates the `live` alias).

Pin shared-workflows to `@v0.2.0` after release (workflows currently use `@main` until tagged).

## E2E (Python first)

1. Apply `hello-api-python` stack in `hello-world-iac`
2. Set variables above from Terraform outputs
3. Run **hello-api-python** workflow with `deploy: true`
4. Curl the API endpoint from Terraform output `api_endpoint`
