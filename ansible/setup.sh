#!/bin/bash

apt-get update && apt-get install -y ansible
ansible-galaxy install -r requirements.yaml
ansible-playbook -i hosts.yaml playbook.yaml

