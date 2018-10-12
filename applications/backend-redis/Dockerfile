FROM redis:4-alpine
COPY redis.conf /usr/local/etc/redis/redis.conf
ENV REDIS_PASSWORD yourpassword
CMD ["sh", "-c", "exec redis-server /usr/local/etc/redis/redis.conf --requirepass \"$REDIS_PASSWORD\""]
