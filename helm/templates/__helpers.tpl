{{- define "deployment_fullname" -}}
{{ .Release.Name }}.deployment
{{- end -}}
