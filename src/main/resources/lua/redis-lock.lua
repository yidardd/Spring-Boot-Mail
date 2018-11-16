local key = KEYS[1];
local value = ARGV[1];
local ttl = tonumber(ARGV[2]);

local lock = redis.call('setnx', key, value);
 
if lock == 1 and ttl > 0 then
	redis.call('expire', key, ttl);
end;

return lock