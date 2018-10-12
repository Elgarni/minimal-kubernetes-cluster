FROM nginx:1.14-alpine

# move my conf
COPY nginx/default.conf /etc/nginx/conf.d/default.conf

# move files
COPY js /usr/share/nginx/html/js
COPY css /usr/share/nginx/html/css
COPY index.html /usr/share/nginx/html/index.html
