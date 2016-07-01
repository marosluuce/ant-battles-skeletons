defmodule Client do
  @base Application.get_env(:skeleton, :server_url)

  def join(name) do
    "#{@base}/join/#{name}" |> request
  end

  def spawn(nest_id) do
    "#{@base}/#{nest_id}/spawn" |> request
  end

  def look(ant_id) do
    "#{@base}/#{ant_id}/look" |> request
  end

  def move(ant_id, direction) do
    "#{@base}/#{ant_id}/move/#{direction}" |> request
  end

  def info(id) do
    "#{@base}/#{id}/stat" |> request
  end

  defp request(url) do
    with {:ok, _, _, client} <- :hackney.get(url),
         {:ok, body} <- :hackney.body(client),
         {:ok, response} <- Poison.decode(body),
      do: response
  end
end
