require 'net/http'
require 'json'

class Client
  SERVER_URL = 'http://localhost:4000'

  class << self
    def join(name)
      request("#{SERVER_URL}/join/#{name}")
    end

    def spawn(nest_id)
      request("#{SERVER_URL}/#{nest_id}/spawn")
    end

    def look(ant_id)
      request("#{SERVER_URL}/#{ant_id}/look")
    end

    def move(ant_id, direction)
      request("#{SERVER_URL}/#{ant_id}/move/#{direction}")
    end

    def info(id)
      request("#{SERVER_URL}/#{id}/stat")
    end

    def request(url)
      uri = URI(url)
      response = Net::HTTP.get(uri)
      JSON.parse(response)
    end
  end
end
